package concurrent;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ThreadLocalRandom;

public class CombineTwoCompletionStages {
  /*

      CompletionStage<Boolean> bool = getConfigBoolean()
      CompletionStage<Optional<Row>> dataRow = loadRow()

      loadRow
          .thenApplyAsync( dataRowOption -> {
              // TODO : combine/compose bool and lyricsRow before this result
              return finalResponse;
          })

  */

  public static void main(String[] args) {
    var obj = new SomeObject();
    var res = obj.loadRow()
        .thenApplyAsync(
            rowOpt -> {
              int n = rowOpt.get().data;
              return new Response("data : " + n);
            })
        .exceptionally(
            ex -> {
              ex.printStackTrace();
              return new Response("error!");
            })
            .thenAccept(r -> System.out.println("Response: " + r.message));

    ((CompletableFuture)res).join();

//    obj.loadRow().thenApply(row -> )

  }
}

class SomeObject {

  CompletionStage<Optional<Row>> loadRow() {
    // calling some sort of storage
    CompletableFuture<Optional<Row>> cf =
        CompletableFuture.supplyAsync(
            () -> {
              int n = ThreadLocalRandom.current().nextInt();
              System.out.println("Main stage: " + n);
              return Optional.of(new Row(n));
            });

    return cf;
  }


  CompletionStage<Boolean> getConfigBoolean() {
    return CompletableFuture.supplyAsync(() -> true);
  }
}

class Row {
  Integer data;

  Row(int n) {
    data = n;
  }
}

class Response {
  String message;

  Response(String m) {
    message = m;
  }
}

package io.sterlang.zrpc

import io.sterlang.zrpc.helloworld.helloworld.ZioHelloworld.GreeterClient
import io.sterlang.zrpc.helloworld.helloworld.HelloRequest
import io.grpc.ManagedChannelBuilder
import zio.console.{putStrLn, _}
import scalapb.zio_grpc.ZManagedChannel
import zio.Layer


object Client extends zio.App {
  val clientLayer: Layer[Throwable, GreeterClient] =
    GreeterClient.live(
      ZManagedChannel(
        ManagedChannelBuilder.forAddress("localhost", 9000).usePlaintext()
      )
    )

  def myAppLogic =
    for {
      r <- GreeterClient.sayHello(HelloRequest("ZIOWorld"))
      _ <- putStrLn(r.message)
    } yield ()

  final def run(args: List[String]) =
    myAppLogic.provideCustomLayer(clientLayer).exitCode
}






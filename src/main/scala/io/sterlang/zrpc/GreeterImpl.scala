package io.sterlang.zrpc


import io.sterlang.zrpc.helloworld.helloworld.{HelloReply, HelloRequest}
import io.sterlang.zrpc.helloworld.helloworld.ZioHelloworld.ZGreeter

import io.grpc.Status
import scalapb.zio_grpc.ServerMain
import scalapb.zio_grpc.ServiceList
import zio.{ZEnv, ZIO}


object GreeterImpl extends ZGreeter[ZEnv, Any] {
  def sayHello(
                request: HelloRequest
              ): ZIO[zio.ZEnv, Status, HelloReply] =
    ZIO.succeed(HelloReply(s"Hello, ${request.name}"))
}

object HelloWorldServer extends ServerMain {
  def services: ServiceList[zio.ZEnv] = ServiceList.add(GreeterImpl)
}

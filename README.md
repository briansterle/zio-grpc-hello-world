# zio-grpc-hello-world

a bare minimum example of zio-grpc implemented in ZIO 1.0.12 and Scala 2.13.7

### Run Server
```bash
sbt "runMain io.sterlang.zrpc.HelloWorldServer"
```


### Run Client
```bash
sbt "runMain io.sterlang.zrpc.Client"
```

Client will output "Hello, ZIOWorld"

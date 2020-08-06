import $ivy.`dev.zio::zio:1.0.0`

import zio._

//val rt = new DefaultRuntime {}
//val rt = Runtime(ZEnv.live, zio.internal.Platform.default)
val rt = Runtime.unsafeFromLayer(ZEnv.live)


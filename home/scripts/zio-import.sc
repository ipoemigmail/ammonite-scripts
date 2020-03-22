import $ivy.`dev.zio::zio:1.0.0-RC18-2`

import zio._

//val rt = new DefaultRuntime {}
val rt = Runtime(ZEnv.live, zio.internal.Platform.default)

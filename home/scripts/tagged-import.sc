type Tagged[U] = { type Tag = U }
type @@[T, U] = T with Tagged[U]

final class Tagger[U] {
  def apply[T](t: T): T @@ U = t.asInstanceOf[T @@ U]
}

def tag[U] = new Tagger[U]

final class Fetcher[U] {
  def apply[T](t: T @@ U): T = t.asInstanceOf[T]
}

def fetch[U] = new Fetcher[U]

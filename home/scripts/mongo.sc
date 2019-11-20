import $ivy.`org.mongodb.scala::mongo-scala-driver:2.6.0`
import org.mongodb.scala._

implicit val toFutureSeqObservable = new ToFutureSeq[Observable] {
  def toFuture[A](fa: Observable[A]): Future[Seq[A]] = fa.toFuture
}

implicit val toFutureSeqListDatabaseObservable = new ToFutureSeq[ListDatabasesObservable] {
  def toFuture[A](fa: ListDatabasesObservable[A]): Future[Seq[A]] = fa.toFuture
}

implicit val toFutureSeqListCollectionsObservable = new ToFutureSeq[ListCollectionsObservable] {
  def toFuture[A](fa: ListCollectionsObservable[A]): Future[Seq[A]] = fa.toFuture
}

implicit val toFutureSeqFindObservable = new ToFutureSeq[FindObservable] {
  def toFuture[A](fa: FindObservable[A]): Future[Seq[A]] = fa.toFuture
}

val client = MongoClient("mongodb://localhost:27017")

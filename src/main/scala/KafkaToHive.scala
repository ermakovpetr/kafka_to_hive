import kafka.serializer.StringDecoder
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.SparkConf
import org.apache.spark.streaming.kafka.KafkaUtils

object KafkaToHive {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("KafkaToHive")
    val ssc = new StreamingContext(conf, Seconds(60))

    val kafkaStream = KafkaUtils.createStream(ssc, "zk-serv1:2181/prod", "spark_streaming", Map("y_searches" -> 1))

    kafkaStream.saveAsTextFiles("/user/tmp/sparktest_out")
    ssc.start()
    ssc.awaitTermination()
  }
}

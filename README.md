# kafka_to_hive

sbt assembly

spark-submit --class KafkaToHive --master yarn --deploy-mode cluster --executor-memory 1G --executor-cores 4 kafka-assembly.jar

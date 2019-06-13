package foo.rmq.producer;


import static foo.rmq.OfflineTaskConstant.*;

public enum OfflineTaskExchange {

  OFFLINE_IMAGE_ANALYZE_EXCHANGE(IMAGE_ANALYZE_QUEUE,
      IMAGE_ANALYZE_KEY,
      OFFLINE_TASK_EXCHANGE, "图片分析队列"),

  OFFLINE_VIDEO_ANALYZE_EXCHANGE(VIDEO_ANALYZE_QUEUE,
      VIDEO_ANALYZE_KEY,
      OFFLINE_TASK_EXCHANGE, "视频分析队列"),

  OFFLINE_TASK_DELETE_EXCHANGE(OFFLINE_TASK_DELETE_QUEUE,
      OFFLINE_TASK_DELETE_KEY,
      OFFLINE_TASK_EXCHANGE, "结构化任务删除队列"),

  OFFLINE_TASK_ITEM_DELETE_EXCHANGE(OFFLINE_TASK_ITEM_DELETE_QUEUE,
      OFFLINE_TASK_ITEM_DELETE_KEY,
      OFFLINE_TASK_EXCHANGE, "结构化任务明细删除队列"),

  OFFLINE_IMAGE_ANALYZE_UNKNOWN_EXCHANGE(OFFLINE_IMAGE_ANALYZE_UNKNOWN_QUEUE,
      OFFLINE_IMAGE_ANALYZE_UNKNOWN_KEY,
      OFFLINE_TASK_EXCHANGE, "图片分析结果未知补偿队列"),

  OFFLINE_VIDEO_ANALYZE_UNKNOWN_EXCHANGE(OFFLINE_VIDEO_ANALYZE_UNKNOWN_QUEUE,
      OFFLINE_VIDEO_ANALYZE_UNKNOWN_KEY,
      OFFLINE_TASK_EXCHANGE, "离线视频创建结果未知补偿队列"),

  OFFLINE_TASK_ITEM_RESOURCE_DELETE_EXCHANGE(OFFLINE_TASK_ITEM_RESOURCE_DELETE_QUEUE,
      OFFLINE_TASK_ITEM_RESOURCE_DELETE_KEY,
      OFFLINE_TASK_EXCHANGE, "视频明细所对应资源删除队列");

  private String queue;
  private String routingKey;
  private String exchange;
  private String desc;


  @SuppressWarnings("unused")
  OfflineTaskExchange(String queue, String routingKey, String exchange, String desc) {
    this.queue = queue;
    this.routingKey = routingKey;
    this.exchange = exchange;
    this.desc = desc;
  }
}

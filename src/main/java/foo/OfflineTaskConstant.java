package foo;


public class OfflineTaskConstant {

  private OfflineTaskConstant() {
  }

  public static final String OFFLINE_TASK_EXCHANGE = "offline_task_topic";

  public static final String OFFLINE_TASK_RETRY_EXCHANGE = "offline_task_retry_topic";

  public static final String OFFLINE_TASK_DELAY_EXCHANGE = "offline_task_delay_topic";

  public static final String OFFLINE_TASK_DELAY_BINDING_KEY = "offline_task_delay.#";

  public static final String OFFLINE_TASK_DELAY_QUEUE = "offline_task_delay_queue";

  public static final String OFFLINE_TASK_IMAGE_DELAY_QUEUE = "offline_task_image_delay_queue";

  public static final String OFFLINE_TASK_IMAGE_DELAY_KEY = "offline_task_delay.image_key";

  public static final String OFFLINE_TASK_VIDEO_DELAY_KEY = "offline_task_delay.video_key";

  public static final String OFFLINE_TASK_VIDEO_DELAY_QUEUE = "offline_task_video_delay_queue";

  public static final String IMAGE_ANALYZE_QUEUE = "offline_image_analyze_queue";
  public static final String IMAGE_ANALYZE_KEY = "offline_image_analyze_key";

  public static final String VIDEO_ANALYZE_QUEUE = "offline_video_analyze_queue";
  public static final String VIDEO_ANALYZE_KEY = "offline_video_analyze_key";

  public static final String OFFLINE_TASK_DELETE_QUEUE = "offline_task_delete_queue";
  public static final String OFFLINE_TASK_DELETE_KEY = "offline_task_delete_key";

  public static final String OFFLINE_TASK_ITEM_DELETE_QUEUE = "offline_task_item_delete_queue";
  public static final String OFFLINE_TASK_ITEM_DELETE_KEY = "offline_task_item_delete_key";

  public static final String OFFLINE_TASK_ITEM_RESOURCE_DELETE_QUEUE = "offline_task_item_resource_delete_queue";
  public static final String OFFLINE_TASK_ITEM_RESOURCE_DELETE_KEY = "offline_task_item_resource_delete_key";

  public static final String OFFLINE_IMAGE_ANALYZE_UNKNOWN_QUEUE = "offline_image_analyze_unknown_queue";
  public static final String OFFLINE_IMAGE_ANALYZE_UNKNOWN_KEY = "offline_image_analyze_unknown_key";

  public static final String OFFLINE_IMAGE_ANALYZE_RETRY_QUEUE = "offline_image_analyze_retry_queue";
  public static final String OFFLINE_IMAGE_ANALYZE_RETRY_KEY = "offline_image_analyze_retry_key";

  public static final String OFFLINE_VIDEO_ANALYZE_UNKNOWN_QUEUE = "offline_video_analyze_unknown_queue";
  public static final String OFFLINE_VIDEO_ANALYZE_UNKNOWN_KEY = "offline_video_analyze_unknown_key";

  public static final String ES_OFFLINE_TASK_CAPTURE_WRITE_ALIAS = "alias_current_offline_capture";
  public static final String ES_OFFLINE_TASK_CAPTURE_READ_ALIAS = "alias_offline_capture";

  public static final String ES_OFFLINE_TASK_WARNING_WRITE_ALIAS = "alias_current_offline_warning";
  public static final String ES_OFFLINE_TASK_WARNING_READ_ALIAS = "alias_offline_warning";

  public static final String REDIS_GROUP = "OFFLINE_TASK_";

  public static final String REDIS_OFFLINE_TASK_PREFIX = "ID_";
  public static final String REDIS_OFFLINE_TASK_ITEM_PREFIX = "ITEM_ID_";
  /**
   * 结构化任务批量处理锁
   */
  public static final String REDIS_OFFLINE_TASK_BATCH_KEY = "BATCH_OPERATION";
  /**
   * REDIS 原子锁持有时间 默认300秒
   */
  public static final Long REDIS_DEFAULT_EXPIRE_TIME = 300L;

  /**
   * REDIS 原子锁最大等待时间
   */
  public static final Long MAX_WAIT_GET_LOCK_TIME = 1L;

  public static final String OFFLINE_TASK_ITEM_PREFIX = "offlineTaskItem";

  public static final String OFFLINE_TASK_BUCKET_IMAGES = "offline-task-bucket-images";

  public static final String SIMPLE_DATE_FORMAT_COMMON = "yyyy-MM-dd HH:mm:ss";

  public static final String OFFLINE_TASK_ITEM_VIDEO_CACHE_PREFIX = "offline_task_item_car_infos";

  /**
   * 离线图片/视频 同步分析最大等待时间
   */
  public static final int OFFLINE_IMAGE_VIDEO_MAX_WAIT_TIME = 10;

  /**
   *
   */
  public static final int OFFLINE_TASK_DELAY_QUEUE_TTL = 10 * 60 * 1000;

  public static final String OFFLINE_TASK_FACE_SET_PREFIX = "offline_task_face_set_";


}

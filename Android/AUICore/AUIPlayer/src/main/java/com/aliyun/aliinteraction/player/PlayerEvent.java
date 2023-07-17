package com.aliyun.aliinteraction.player;

/**
 * Created by KyleCe on 2021/7/2
 */
public enum PlayerEvent {
    RENDER_START,
    PLAYER_LOADING_BEGIN,
    PLAYER_LOADING_PROGRESS,
    PLAYER_LOADING_END,
    PLAYER_ERROR,
    PLAYER_ERROR_RAW,
    PLAYER_PREPARED,
    BUFFERED_POSITION,
    CURRENT_POSITION,
    @Deprecated
    RTS_PLAYER_ERROR,
    @Deprecated
    PLAYER_HTTP_RANGE_ERROR,
    PLAYER_END,
    PLAYER_VIDEO_SIZE,
    PLAYER_VIDEO_RENDERED,
    PLAYER_STATUS_CHANGE,
    PLAYER_DOWNLOAD_SPEED_CHANGE,
}

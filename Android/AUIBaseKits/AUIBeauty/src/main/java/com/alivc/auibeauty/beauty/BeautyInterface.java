package com.alivc.auibeauty.beauty;

import com.alivc.auibeauty.beauty.constant.BeautyImageFormat;

/**
 * 美颜基础接口类
 *
 * @note 由于beauty模块是插件化，因此beauty实例是通过反射进行实例化，请注意修改美颜具体实现（impl）类名，以免出现美颜初始化失败导致美颜失效的问题
 * @note 调用：在类AliLiveRoom中的getBeautyManager()进行无差别调用；
 * @note 实现：不同厂商的美颜，须继承自该类进行扩展实现；
 */
public interface BeautyInterface {

    ////////////    1、美颜生命周期相关接口    ////////////

    /**
     * 初始化美颜
     */
    void init();

    /**
     * 销毁、释放美颜
     */
    void release();

    ////////////    2、美颜接口    ////////////

    /**
     * 开启/关闭美颜
     *
     * @param enable 是否开启
     */
    void setBeautyEnable(boolean enable);

    /**
     * 开启/关闭美颜类型
     *
     * @param type   美颜类型，如：美颜、美妆、美型、滤镜等
     * @param enable 是否开启
     */
    void setBeautyType(int type, boolean enable);


    ////////////    3、美颜参数接口    ////////////

    /**
     * 设置美颜
     *
     * @param type  美颜类型
     * @param value 美颜参数值
     */
    void setBeautyParams(int type, float value);

    /**
     * 设置美型
     *
     * @param type  美型类型
     * @param value 美型参数值
     */
    void setFaceShapeParams(int type, float value);

    /**
     * 设置美妆
     *
     * @param type 美妆类型
     * @param path 美妆路径
     */
    void setMakeupParams(int type, String path);

    /**
     * 设置滤镜
     *
     * @param path 滤镜的路径，path为空移除滤镜
     */
    void setFilterParams(String path);

    /**
     * 设置贴纸/贴图
     *
     * @param path 贴纸/贴图的路径
     */
    void setMaterialParams(String path);

    /**
     * 删除贴纸/贴图
     *
     * @param path 贴纸/贴图的路径
     */
    void removeMaterialParams(String path);


    ////////////    4、美颜输入输出    ////////////

    /**
     * 纹理输入接口，用于图像处理
     *
     * @param inputTexture  输入纹理id
     * @param textureWidth  纹理宽度
     * @param textureHeight 纹理高度
     * @return 输出纹理
     * @note 默认输出为Sample2D格式的纹理
     */
    int onTextureInput(int inputTexture, int textureWidth, int textureHeight);

    /**
     * 帧数据输入接口，用于图像处理
     *
     * @param image  byte数组形式的帧数据
     * @param format 帧数据类型，rgba、rgb、nv21等，参考{@linkplain BeautyImageFormat}
     * @param width  帧宽
     * @param height 帧高
     * @param stride 顶点间隔
     */
    void onDrawFrame(byte[] image, @BeautyImageFormat int format, int width, int height, int stride);

    /**
     * 帧数据输入接口，用于图像处理
     *
     * @param imageNativeBufferPtr 图像native buffer的内存首地址
     * @param format               帧数据类型，rgba、rgb、nv21等，参考{@linkplain BeautyImageFormat}
     * @param width                帧宽
     * @param height               帧高
     * @param stride               顶点间隔
     */
    void onDrawFrame(long imageNativeBufferPtr, @BeautyImageFormat int format, int width, int height, int stride, int cameraId);


    void switchCameraId(int cameraId);

    ////////////    5、美颜其它接口    ////////////

    /**
     * 获取版本号
     *
     * @return 版本号
     */
    String getVersion();
}
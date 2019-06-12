package com.liying;

import java.nio.file.attribute.UserDefinedFileAttributeView;

/**
 * 创建者:小䶮
 */
public interface IHellloService {
    public String sayhello(String content);

    public int saveUser(User user);
}

package com.liying;

/**
 * 创建者:小䶮
 */
public class HelloServiceImpl implements IHellloService{
    @Override
    public String sayhello(String content) {
        return "come in" + content;
    }

    @Override
    public int saveUser(User user) {
        System.out.println("save success");
        return 1;
    }
}

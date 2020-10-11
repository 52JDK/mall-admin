package com.robot.admin.util;

import com.robot.admin.pojo.SysUsers;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordHelper {
    private static final RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    public static final String ALGORITHM_NAME = "md5"; // 基础散列算法
    public static final int HASH_ITERATIONS = 2; // 自定义散列次数

    public static void encryptPassword(SysUsers user) {
        // 随机字符串作为salt因子，实际参与运算的salt我们还引入其它干扰因子
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(ALGORITHM_NAME, user.getPassWord(),
                ByteSource.Util.bytes(user.getSalt()), HASH_ITERATIONS).toHex();
        user.setPassWord(newPassword);
    }

    public static String passWordHash(SysUsers user, String passWord) {
        return new SimpleHash(ALGORITHM_NAME, passWord,
                ByteSource.Util.bytes(user.getSalt()), HASH_ITERATIONS).toHex();
    }


    public static boolean checkPassWord(SysUsers user, String passWord) {
        //通过同样的散列算法验证密码是否正确
        String userPassword = new SimpleHash(ALGORITHM_NAME, passWord,
                ByteSource.Util.bytes(user.getSalt()), HASH_ITERATIONS).toHex();
        return StringUtils.equals(user.getPassWord(), userPassword);
    }

    /**
     * 该方法可以设置用户的密码
     * @param args
     */
    public static void main(String[] args) {
        SysUsers sysUsers=new SysUsers();
        sysUsers.setUserName("admin");
        sysUsers.setPassWord("123456");
        encryptPassword(sysUsers);
        System.out.println(sysUsers);
    }


}
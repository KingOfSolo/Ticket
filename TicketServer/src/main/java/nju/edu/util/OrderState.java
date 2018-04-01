package nju.edu.util;

/**
 * Created by xiaoJun on 2018/3/31.
 */
public class OrderState {
    public static final int Pay = 1;      //待支付
    public static final int Success = 3;  //支付成功
    public static final int Fail = 4;     //交易取消
    public static final int Refund = 5;   //退订
}

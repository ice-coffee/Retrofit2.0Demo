package org.goodev.retrofitdemo.bean;

/**
 * Author:  ice_coffee
 * Email:   ice_coffee_mzp@163.com
 * Date:    2016/6/23
 * Description: bean类
 */
public class Contributor
{
    String login;
    int contributions;

    @Override
    public String toString() {
        return login + ", " + contributions;
    }
}

package com.annotation;

/**
 * Created by peng.zhang
 * Description:
 * Son类继承了Father类的@PeopleValue注解
 * 因为@PeopleValue注解使用了@Inherit注解表明可继承
 * Time: 2021/1/7-16:00.
 */
@Game("monster hunter: world")
@Game("ori and the will of the wisp")
@Game("dead cells")
public class Son extends Father {
}

@People({@Game("sekiro")})
class LittleSon {

}

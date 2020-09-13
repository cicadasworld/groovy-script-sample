package oop.traits

/**
 * create by
 * @author hujin 2020/9/9
 */
class Bird implements FlyingAbility, SpeakingAbility {

    @Override
    String foo() {
        return "foo"
    }
}

package ProxyPattern;

import java.lang.reflect.Proxy;

/**
 * 代理模式
 * 动态代理
 */
public class MatchMakingTestDrive {


    public static void main(String[] args) {
        MatchMakingTestDrive test = new MatchMakingTestDrive();
        test.drive();

    }

    public MatchMakingTestDrive() {

    }

    public void drive() {
        PersonBean joe = getPersonFromDatabase("Joe Javabean");
        PersonBean ownerProxy = getOwnerProxy(joe);
        System.out.println("Name is " + ownerProxy.getName());
        ownerProxy.setInterests("bowling,Go");
        System.out.println("Interests set from owner proxy");
        try {
            ownerProxy.setHotOrNotRating(10);
        } catch (Exception e) {
            System.out.println("Can't set rating from owner proxy");
        }
        System.out.println("Rating is " + ownerProxy.getHotOrNotRating());

        PersonBean nonOwnerProxy = getNonOwnerProxy(joe);
        System.out.println("Name is " + nonOwnerProxy.getName());
        try {
            nonOwnerProxy.setInterests("bowling,Go");
        } catch (Exception e) {
            System.out.println("Can't set interests from non owner proxy");
        }
        nonOwnerProxy.setHotOrNotRating(3);
        System.out.println("Rating set from non owner proxy");
        System.out.println("Rating is" + nonOwnerProxy.getHotOrNotRating());

    }

    PersonBean getOwnerProxy(PersonBean personBean) {
        return (PersonBean) Proxy.newProxyInstance(personBean.getClass().getClassLoader(), personBean.getClass().getInterfaces(), new OwnerInvocationHandler(personBean));
    }

    PersonBean getNonOwnerProxy(PersonBean personBean) {
        return (PersonBean) Proxy.newProxyInstance(personBean.getClass().getClassLoader(), personBean.getClass().getInterfaces(), new NonOwnerInvocationHandler(personBean));
    }

    PersonBean getPersonFromDatabase(String name) {
        return new PersonBean() {
            @Override
            public String getName() {
                return name;
            }

            @Override
            public String getGender() {
                return null;
            }

            @Override
            public String getInterests() {
                return null;
            }

            @Override
            public int getHotOrNotRating() {
                return 0;
            }

            @Override
            public void setName(String name) {

            }

            @Override
            public void setGender(String gender) {

            }

            @Override
            public void setInterests(String interests) {

            }

            @Override
            public void setHotOrNotRating(int rating) {

            }
        };
    }
}

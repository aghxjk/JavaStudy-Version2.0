package com.zym.chapter07;

/**
 * Created by zhaoyimeng on 15/11/24.
 *
 * 1.Collection(Interface) extends Iterable
 *     |--List(Interface)
 *         |--ArrayList
 *         |--Vector
 *         |--LinkedList
 *     |--Set(Interface)
 *         |--HashSet
 *         |--SortedSet(Interface)
 *             |--TreeSet
 *
 *     a. 只能存储引用类型, 基础数据类型不支持,例如: int long double float
 *     b. List 和 Set 两个接口继承了该接口
 *     c. 存储在集合中的对象都需要重写equals方法
 *     d. 集合遍历借助迭代器
 *     e. 集合中的元素删除最好使用迭代器
 *
 * 2.List(Interface)集合
 *     a. 有序可重复
 *     b. 深入List集合( 如下3个类是接口List的实现 )
 *         (1)ArrayList和Vector底层是数组,数组有下标;
 *         (2)ArrayList默认初始化容量为10,扩容之后为原来的1.5倍
 *         (3)Vector集合默认初始化容量为10,扩容之后为原来的2倍(线程安全,效率低,很少用)
 *         (4)如何优化 Vector 和 ArrayList？
 *            - 尽量减少扩容操作;
 *            - 推荐创建集合的时候指定初始化容量;
 *         (5)LinkedList为双向链表, 适合频繁增删, 不适合频繁随机查询
 *
 * 3.Set(Interface)集合
 *     a. 无序不可重复
 *     b. HashSet底层实际是一个HashMap, HashMap底层采用了哈希表(散列表)数据结构,是一个数组,每个数组元素是一个单向链表.
 *        每个单向链表有一个独一无二的hash值,代表数组下标.
 *     c. 向哈希表中添加元素:
 *        (1)先调用被存储key的hashCode方法,获得hash值;
 *        (2)如果哈希表中不存在该值,则直接加入该元素;
 *        (3)如果哈希值存在,继续调用key之间的equals方法,如果equals为false,则添加该元素,否则放弃添加;
 *     d. HashSet是HashMap中的key部分.
 *     e. HashSet和HashMap的初始化容量都是16, 默认加载因子是0.75
 *
 *     重要:
 *     (1)存储在HashSet集合 或 HashMap集合key部分的元素,需要同时重写hashCode() 和 equals() 方法
 *
 * 4. SortedSet(Interface)
 *     a. SortedSet 继承了 Set
 *     b. TreeSet(二叉树) 是SortedSet的实现类
 *     c. TreeSet中的元素必须实现Comparable接口 或 实现一个比较器
 *
 *     重要: 自己创建的类需要实现comparable()
 *
 * 5.Map(Interface)集合
 *    |--HashMap
 *    |--HashTable
 *         |--Properties
 *    |--SortedMap(Interface)
 *         |--TreeMap
 *
 *     a. HashMap默认初始化容量是16,默认加载因子0.75;
 *     b. HashTable默认初始化容量是11,默认加载因子0.75;
 *     c. Properties也是由Key和Value对组成,但key和value都是字符串类型
 *        注意事项:
 *            详见PropertiesTest类
 *
 *     d. SortedMap中Key的特点: 无序不可重复,但存进去的元素按照大小自动化排列
 *        如果想自动化排序: Key部分元素需要
 *        1. 实现Comparable接口
 *        2. 或者单独写一个比较器Comparator
 *
 * 6.Collections集合工具类
 *     a. sort() 排序方法, 如果是自定义类,需求实现Comparatable
 *
 * 7.泛型初步
 *     7.1 为什么引入泛型?
 *         a. 可以统一集合中的数据类型;
 *         b. 可以减少强制类型转换;
 *
 *     7.2 泛型语法如何实现?
 *         a. 泛型是一个编译阶段的语法, 编译解决统一集合中的类型
 *
 *     7.3 泛型优缺点?
 *         优点: 统一类型,减少转换;
 *         缺点: 类型太统一(即: 只能存储一种类型)
 *
 *         a. 如果集合不使用泛型, 则集合中的元素类型不统一;
 *         b. 在遍历集合时,只能用Object类型,需要做大量的强制类型转换;
 *
 *     7.4 自定义泛型
 *
 * 8. 增强for循环
 *     8.1 语法:
 *         for ( 类型 变量:数组名/集合){}
 *         注意: 集合使用增强for循环需要使用泛型,如果不用泛型则要用Object类型
 *         缺点: 没有下标
 *
 *
 */
public class Chapter07 {
    public static void main(String[] args) {


        if (true) {
            CollectionTest.test_1();
            CollectionTest.test_2();

            ListTest.test_1();

            SetTest.test_1();
            SetTest.test_2();
            SetTest.test_3();
            SetTest.test_4();//Comparable实现方式1
            SetTest.test_5();//Comparator   实现方式2  推荐

            MapTest.test_1();//HashMap
            MapTest.test_2();//TreeMap
            PropertiesTest.test_1(); //读取tmpProperties.properties

            CollectionsTest.test_1();//集合工具类
            CollectionsTest.test_2();//集合工具类

            GenericTest.test_1();//泛型初步(List<E>)
            GenericTest.test_2();//泛型初步(Map<K V>
            GenericTest.test_3();//泛型初步(SortedSet)
            GenericTest.test_4();//自定义泛型
            GenericTest.test_5();//增强for循环
        }
    }
}

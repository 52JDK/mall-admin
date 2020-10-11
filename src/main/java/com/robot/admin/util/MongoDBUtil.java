package com.robot.admin.util;



import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @author robot
 */
@Component
public class MongoDBUtil {


    public static MongoDBUtil mongodbUtils;

    @PostConstruct
    public void init() {
        mongodbUtils = this;
    }

    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * 保存数据对象，集合为数据对象中@Document 注解所配置的collection
     *
     * @param obj 数据对象
     */
    public static void save(Object obj) throws Exception {

        mongodbUtils.mongoTemplate.save(obj);
    }

    /**
     * 指定集合保存数据对象
     *
     * @param obj            数据对象
     * @param collectionName 集合名
     */
    public static void save(Object obj, String collectionName) throws Exception {

        mongodbUtils.mongoTemplate.save(obj, collectionName);
    }

    /**
     * 批量插入
     * @param entityClass
     * @param collectionName
     * @throws Exception
     */
    public static void saveBatch(Collection<?> batchToSave, Class<?> entityClass, String collectionName) throws Exception {
        mongodbUtils.mongoTemplate.insert(batchToSave,entityClass);
    }


    /**
     * 根据数据对象中的id删除数据，集合为数据对象中@Document 注解所配置的collection
     *
     * @param obj 数据对象
     */
    public static void remove(Object obj) throws Exception {

        mongodbUtils.mongoTemplate.remove(obj);
    }

    /**
     * 指定集合 根据数据对象中的id删除数据
     *
     * @param obj            数据对象
     * @param collectionName 集合名
     */
    public static void remove(Object obj, String collectionName) throws Exception {

        mongodbUtils.mongoTemplate.remove(obj, collectionName);
    }

    /**
     * 根据key，value到指定集合删除数据
     *
     * @param key            键
     * @param value          值
     * @param collectionName 集合名
     */
    public static void removeById(String key, Object value, String collectionName) throws Exception {

        Criteria criteria = Criteria.where(key).is(value);
        Query query = Query.query(criteria);
        mongodbUtils.mongoTemplate.remove(query, collectionName);
    }

    /**
     * 指定集合 修改数据，且仅修改找到的第一条数据
     *
     * @param accordingKey   修改条件 key
     * @param accordingValue 修改条件 value
     * @param updateKeys     修改内容 key数组
     * @param updateValues   修改内容 value数组
     * @param collectionName 集合名
     */
    public static void updateFirst(String accordingKey, Object accordingValue, String[] updateKeys, Object[] updateValues,
                                   String collectionName) throws Exception {

        Criteria criteria = Criteria.where(accordingKey).is(accordingValue);
        Query query = Query.query(criteria);
        Update update = new Update();
        for (int i = 0; i < updateKeys.length; i++) {
            update.set(updateKeys[i], updateValues[i]);
        }
        mongodbUtils.mongoTemplate.updateFirst(query, update, collectionName);
    }

    /**
     * 指定集合 修改数据，且修改所找到的所有数据
     *
     * @param accordingKey   修改条件 key
     * @param accordingValue 修改条件 value
     * @param updateKeys     修改内容 key数组
     * @param updateValues   修改内容 value数组
     * @param collectionName 集合名
     */
    public static void updateMulti(String accordingKey, Object accordingValue, String[] updateKeys, Object[] updateValues,
                                   String collectionName) throws Exception {

        Criteria criteria = Criteria.where(accordingKey).is(accordingValue);
        Query query = Query.query(criteria);
        Update update = new Update();
        for (int i = 0; i < updateKeys.length; i++) {
            update.set(updateKeys[i], updateValues[i]);
        }
        mongodbUtils.mongoTemplate.updateMulti(query, update, collectionName);
    }

    /**
     * 根据条件查询出所有结果集 集合为数据对象中@Document 注解所配置的collection
     *
     * @param obj        数据对象
     * @param findKeys   查询条件 key
     * @param findValues 查询条件 value
     * @return
     */
    public static List<?> find(Object obj, String[] findKeys, Object[] findValues) throws Exception {

        Criteria criteria = null;
        for (int i = 0; i < findKeys.length; i++) {
            if (i == 0) {
                criteria = Criteria.where(findKeys[i]).is(findValues[i]);
            } else {
                criteria.and(findKeys[i]).is(findValues[i]);
            }
        }
        Query query = Query.query(criteria);
        return mongodbUtils.mongoTemplate.find(query, obj.getClass());
    }

    public static List<?> find(Object obj, String findKey, Object findValue, String collectioName, String sort) throws Exception {
        Criteria criteria = Criteria.where(findKey).is(findValue);
        Query query = Query.query(criteria);
        query.with(Sort.by(Sort.Order.desc(sort)));
        return mongodbUtils.mongoTemplate.find(query, obj.getClass(), collectioName);
    }

    /**
     * 指定集合 根据条件查询出所有结果集
     *
     * @param obj            数据对象
     * @param findKeys       查询条件 key
     * @param findValues     查询条件 value
     * @param collectionName 集合名
     * @return
     */
    public static List<? extends Object> find(Object obj, String[] findKeys, Object[] findValues, String collectionName) {

        Criteria criteria = null;
        for (int i = 0; i < findKeys.length; i++) {
            if (i == 0) {
                criteria = Criteria.where(findKeys[i]).is(findValues[i]);
            } else {
                criteria.and(findKeys[i]).is(findValues[i]);
            }
        }
        Query query = Query.query(criteria);
        List<? extends Object> resultList = mongodbUtils.mongoTemplate.find(query, obj.getClass(), collectionName);
        return resultList;
    }

    /**
     * 指定集合 根据条件查询出所有结果集 并排倒序
     *
     * @param obj            数据对象
     * @param findKeys       查询条件 key
     * @param findValues     查询条件 value
     * @param collectionName 集合名
     * @param sort           排序字段
     * @return
     */
    public static List<?> find(Object obj, String[] findKeys, Object[] findValues, String collectionName, String sort) {

        Criteria criteria = null;
        for (int i = 0; i < findKeys.length; i++) {
            if (i == 0) {
                criteria = Criteria.where(findKeys[i]).is(findValues[i]);
            } else {
                criteria.and(findKeys[i]).is(findValues[i]);
            }
        }
        assert criteria != null;
        Query query = Query.query(criteria);
        query.with(Sort.by(Sort.Direction.DESC, sort));
        return mongodbUtils.mongoTemplate.find(query, obj.getClass(), collectionName);
    }

    /**
     * 根据条件查询出符合的第一条数据 集合为数据对象中 @Document 注解所配置的collection
     *
     * @param obj        数据对象
     * @param findKeys   查询条件 key
     * @param findValues 查询条件 value
     * @return
     */
    public static Object findOne(Object obj, String[] findKeys, Object[] findValues) {

        Criteria criteria = null;
        for (int i = 0; i < findKeys.length; i++) {
            if (i == 0) {
                criteria = Criteria.where(findKeys[i]).is(findValues[i]);
            } else {
                criteria.and(findKeys[i]).is(findValues[i]);
            }
        }
        Query query = Query.query(criteria);
        Object resultObj = mongodbUtils.mongoTemplate.findOne(query, obj.getClass());
        return resultObj;
    }

    /**
     * 查询一个信息
     *
     * @param obj
     * @param findKey
     * @param findValue
     * @return
     */
    public static Object findOne(Object obj, String findKey, Object findValue, String collectionName) {
        Criteria criteria = null;
        criteria = Criteria.where(findKey).is(findValue);
        Query query = Query.query(criteria);
        return mongodbUtils.mongoTemplate.findOne(query, obj.getClass(), collectionName);
    }

    /**
     * 指定集合 根据条件查询出符合的第一条数据
     *
     * @param obj            数据对象
     * @param findKeys       查询条件 key
     * @param findValues     查询条件 value
     * @param collectionName 集合名
     * @return
     */
    public static Object findOne(Object obj, String[] findKeys, Object[] findValues, String collectionName) {

        Criteria criteria = null;
        for (int i = 0; i < findKeys.length; i++) {
            if (i == 0) {
                criteria = Criteria.where(findKeys[i]).is(findValues[i]);
            } else {
                criteria.and(findKeys[i]).is(findValues[i]);
            }
        }
        assert criteria != null;
        Query query = Query.query(criteria);
        return mongodbUtils.mongoTemplate.findOne(query, obj.getClass(), collectionName);
    }

    /**
     * 查询出所有结果集 集合为数据对象中 @Document 注解所配置的collection
     *
     * @param obj
     * @return
     */
    public static List<?> findAll(Object obj) {

        return mongodbUtils.mongoTemplate.findAll(obj.getClass());
    }

    /**
     * 指定集合 查询出所有结果集
     *
     * @param obj            数据对象
     * @param collectionName 集合名
     */
    public static List<?> findAll(Object obj, String collectionName) {

        return mongodbUtils.mongoTemplate.findAll(obj.getClass(), collectionName);

    }

    /**
     * @param obj
     * @param key
     * @param pageNum
     * @param pageSize
     * @return
     */
    public static List<?> findAllOrderBy(Object obj, String key, int pageNum, int pageSize) {
        Query query = new Query();
        query.skip((pageNum - 1) * pageSize);
        query.limit(pageSize);
        query.with(Sort.by(Sort.Order.desc(key)));
        return mongodbUtils.mongoTemplate.find(query, obj.getClass());
    }

//    public static void saveOne(BlogMessageChild blogMessageChild) {
//        Query query = Query.query(Criteria.where("_id").is(blogMessageChild.getToId()));
//        Update update = new Update();
//        update.addToSet("blogMessageChild", blogMessageChild);
//        mongodbUtils.mongoTemplate.upsert(query, update, BlogMessage.class);
//
//    }

    public static long findCount(String collectionName) {
        return mongodbUtils.mongoTemplate.getCollection(collectionName).countDocuments();
    }
}

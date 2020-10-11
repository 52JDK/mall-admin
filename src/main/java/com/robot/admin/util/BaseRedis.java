package com.robot.admin.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.Map;


/**
 * @author robot
 * @date 2019/12/9 17:29
 */
@Component
public class BaseRedis {

    @Resource
    private JedisPool jedisPool;

    private static Logger logger = LoggerFactory.getLogger(BaseRedis.class);

    public void set(String key, String str) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.set(key, str);
        } catch (Exception e) {
            logger.error("redis set error", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public void set(String key, String str, int time) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.set(key, str);
            jedis.expire(key, time);
        } catch (Exception e) {
            logger.error("redis set error", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public void setnx(String key, String str, int time) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.setnx(key, str);
        } catch (Exception e) {
            logger.error("redis set error", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.get(key);
        } catch (Exception e) {
            logger.error("redis set error", e);
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public Long del(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.del(key);
        } catch (Exception e) {
            logger.error("redis del error", e);
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public String set(String key, String value, String nxxx, String expx, long time) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.set(key, value, nxxx, expx, time);
        } catch (Exception e) {
            logger.error("redis set error", e);
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

    }

    public Long incr(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.incr(key);
        } catch (Exception e) {
            logger.error("redis incr error", e);
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

    }

    public Long decr(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.decr(key);
        } catch (Exception e) {
            logger.error("redis decr error", e);
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public Long decrBy(String key, long integer) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.decrBy(key, integer);
        } catch (Exception e) {
            logger.error("redis decr error", e);
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public Boolean sismember(String key, String integer) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.sismember(key, integer);
        } catch (Exception e) {
            logger.error("redis sismember error", e);
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }


    public Long sadd(String key, String members) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.sadd(key, members);
        } catch (Exception e) {
            logger.error("redis sadd error", e);
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }


    public Long expire(String key, int seconds) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.expire(key, seconds);
        } catch (Exception e) {
            logger.error("redis expire error", e);
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public Boolean hexists(String key, String field) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.hexists(key, field);
        } catch (Exception e) {
            logger.error("redis hexists error", e);
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public String hget(String key, String field) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.hget(key, field);
        } catch (Exception e) {
            logger.error("redis hget error", e);
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public Map<String, String> hgetAll(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.hgetAll(key);
        } catch (Exception e) {
            logger.error("redis hgetAll error", e);
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public Long hset(String key,String field,String value) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.hset(key,field,value);
        } catch (Exception e) {
            logger.error("redis hset error", e);
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public Long hdel(String key,String field) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.hdel(key,field);
        } catch (Exception e) {
            logger.error("redis hdel error", e);
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public String hmset(String key,Map<String, String> hash) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.hmset(key,hash);
        } catch (Exception e) {
            logger.error("redis hmset error", e);
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}

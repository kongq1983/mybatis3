package com.kq.plugins;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * SelectPlugin
 *
 * @author kq
 * @date 2019-01-31
 */


//@Intercepts({@Signature(
//        type= Executor.class,
//        method = "select",
//        args = {MappedStatement.class,Object.class})})
@Intercepts({
    @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class SelectPlugin implements Interceptor {


    Log logger = LogFactory.getLog(SelectPlugin.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        logger.debug("SelectPlugin.invocation execute.");

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        logger.debug("SelectPlugin.target execute.");
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        logger.debug("properties:{}"+properties);
    }
}

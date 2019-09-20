/*
package global.com.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

@SpringBootConfiguration
@MapperScan("com.blackhole.matchs.mybatis.mapper")
///@PropertySource("classpath:/jdbc/d.properties")
public class DataConfig implements TransactionManagementConfigurer {
	
	@Autowired
	Environment env;
	@Value("${mybatis.config-location}")
	private String myBatisConfigPath;
	@Value("${mybatis.mapper-locations}")
	private String mapperXMLConfigPath;
	@Value("${mybatis.package-locations}")
	private String mapperPackagePath;
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.driver-class-name}")
	private String driver;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	*/
/*@Autowired
	private DataSource dataSource;*//*



	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
	    String packageXMLConfigPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperXMLConfigPath;

		// 设置MyBatis 配置文件的路径
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(myBatisConfigPath));
		// 设置mapper 对应的XML 文件的路径
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageXMLConfigPath));
		// 设置数据源
		sqlSessionFactoryBean.setDataSource(dataSource());
		// 设置mapper 接口所在的包
		sqlSessionFactoryBean.setTypeAliasesPackage(mapperPackagePath);

		return sqlSessionFactoryBean;
	}
	
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());

        return transactionManager;
    }

    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return transactionManager();
    }
}
*/

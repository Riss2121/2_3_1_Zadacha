package web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Указывает, какие конфигурации используются для Spring MVC (контроллеры, view resolver)
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    // Указывает, какие конфигурации используются для корневого контекста (сервисы, репозитории, БД)
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{HibernateConfig.class}; // или AppConfig, если у тебя одна общая конфигурация
    }

    // Указывает, на какие URL будет отвечать DispatcherServlet
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
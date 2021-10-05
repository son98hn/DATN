package com.example.datn.Config;

import com.example.datn.service.impl.ConnectionSignUpImpl;
import com.example.datn.service.impl.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.security.AuthenticationNameUserIdSource;

import javax.sql.DataSource;

/**
 * @author: Pham Ngoc Son
 * <p>
 * Oct 04, 2021
 */
@Configuration
@EnableSocial
@PropertySource("classpath:application.properties")
public class SocialConfig implements SocialConfigurer {
    private boolean autoSignup = false;

    private final
    DataSource dataSource;

    private final UserService userService;

    public SocialConfig(UserService userService, DataSource dataSource) {
        this.userService = userService;
        this.dataSource = dataSource;
    }

    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment) {
        try {
            this.autoSignup = Boolean.parseBoolean(environment.getProperty("social.auto-signup"));
        } catch (Exception e) {
            this.autoSignup = false;
        }
//        FB
        FacebookConnectionFactory facebookConnectionFactory = new FacebookConnectionFactory(
                environment.getProperty("facebook.app.id"),
                environment.getProperty("facebook.app.secret"));
        facebookConnectionFactory.setScope(environment.getProperty("facebook.scope"));
        connectionFactoryConfigurer.addConnectionFactory(facebookConnectionFactory);
//        GG
//        GoogleConnectionFactory googleConnectionFactory = new GoogleConnectionFactory(//
//                environment.getProperty("google.client.id"), //
//                environment.getProperty("google.client.secret"));
//        googleConnectionFactory.setScope(environment.getProperty("google.scope"));
//        connectionFactoryConfigurer.addConnectionFactory(googleConnectionFactory);
    }

    @Override
    public UserIdSource getUserIdSource() {
        return new AuthenticationNameUserIdSource();
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        JdbcUsersConnectionRepository usersConnectionRepository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
        if (autoSignup) {
            // After logging in to social networking.
            // Automatically creates corresponding APP_USER if it does not exist.
            ConnectionSignUp connectionSignUp = new ConnectionSignUpImpl(userService);
            usersConnectionRepository.setConnectionSignUp(connectionSignUp);
        } else {
            // After logging in to social networking.
            // If the corresponding APP_USER record is not found.
            // Navigate to registration page.
            usersConnectionRepository.setConnectionSignUp(null);
        }
        return usersConnectionRepository;
    }

    // This bean manages the connection flow between the account provider
    // and the example application.
    @Bean
    public ConnectController connectController(ConnectionFactoryLocator connectionFactoryLocator, ConnectionRepository connectionRepository) {
        return new ConnectController(connectionFactoryLocator, connectionRepository);
    }
}

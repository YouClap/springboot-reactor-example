package tech.youclap.example.springboot

import com.github.jasync.r2dbc.mysql.JasyncConnectionFactory
import com.github.jasync.sql.db.mysql.pool.MySQLConnectionFactory
import io.r2dbc.spi.ConnectionFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@Configuration
@EnableR2dbcRepositories
class DatabaseConfiguration(
    @Value("\${database.host}") private val host: String,
    @Value("\${database.port}") private val port: Int,
    @Value("\${database.database}") private val database: String,
    @Value("\${database.username}") private val username: String,
    @Value("\${database.password}") private val password: String
) : AbstractR2dbcConfiguration() {

    override fun connectionFactory(): ConnectionFactory {

        val configuration = com.github.jasync.sql.db.Configuration(username, host, port, password, database)

        val connectionFactory = MySQLConnectionFactory(configuration)

        return JasyncConnectionFactory(connectionFactory)
    }
}

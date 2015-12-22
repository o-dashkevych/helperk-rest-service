package ua.nure.helperk.dao.impl;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.nure.helperk.dao.MessageDAO;
import ua.nure.helperk.entity.Message;

/**
 * @author Oleg Dashkevych.
 */
@Repository
@Transactional
public class DefaultMessageDao extends GenericDAOImpl<Message, Long> implements MessageDAO {
}

package com.nagarro.week4.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.nagarro.week4.model.Tshirt;

@Component
public class TshirtDao {
	@Autowired
	HibernateTemplate hibernateTemplate;

	@Transactional
	public void save(Tshirt t) {
		System.out.println(t.getId()+t.getColor()+t.getGender()+t.getName());
		this.hibernateTemplate.saveOrUpdate(t);
	}

	public List<Tshirt> getAll() {
		List<Tshirt> products = this.hibernateTemplate.loadAll(Tshirt.class);
		return products;
	}

	public List<Tshirt> matchingData(String color, String size, String gender, String preference) {
		List<Tshirt> matchedShirts = new ArrayList<Tshirt>();
		SessionFactory sessionFactory = this.hibernateTemplate.getSessionFactory();
		Session session = sessionFactory.openSession();
		if (preference.equals("Price")) {
			for (Tshirt tshirt : session.createQuery(
					"from Tshirt t where t.color=:color and t.size=:size and t.gender=:gender order by t.price asc",
					Tshirt.class).setParameter("color", color).setParameter("size", size).setParameter("gender", gender)
					.getResultList()) {
				matchedShirts.add(tshirt);
			}
		} else if (preference.equals("Rating")) {
			for (Tshirt tshirt : session.createQuery(
					"from Tshirt t where t.color=:color and t.size=:size and t.gender=:gender order by t.rating desc",
					Tshirt.class).setParameter("color", color).setParameter("size", size).setParameter("gender", gender)
					.getResultList()) {
				matchedShirts.add(tshirt);
			}

		} else if (preference.equals("Both")) {
			for (Tshirt tshirt : session.createQuery(
					"from Tshirt t where t.color=:color and t.size=:size and t.gender=:gender order by t.price asc, t.rating desc",
					Tshirt.class).setParameter("color", color).setParameter("size", size).setParameter("gender", gender)
					.getResultList()) {
				matchedShirts.add(tshirt);
			}

		}

		return matchedShirts;
	}
}

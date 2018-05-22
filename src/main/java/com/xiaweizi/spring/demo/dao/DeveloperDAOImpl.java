package com.xiaweizi.spring.demo.dao;

import com.xiaweizi.spring.demo.model.DeveloperModel;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

@Repository("developerDAOImpl")
public class DeveloperDAOImpl implements DeveloperDAO {
    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<DeveloperModel> getAllDevelopers() {
        String sql = "select * from developer";

        return query(sql);
    }

    @Override
    public DeveloperModel getDeveloper(String developerId) {
        String sql = "select * from developer where id=" + developerId;
        List<DeveloperModel> developerList = query(sql);
        if (developerList.size() > 0) {
            return developerList.get(0);
        } else {
            return null;
        }

    }

    private List<DeveloperModel> query(String sql) {
        final List<DeveloperModel> developerList = new ArrayList<>();
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String site = resultSet.getString(3);
                String avatar = resultSet.getString(4);
                DeveloperModel developerModel = new DeveloperModel();
                developerModel.setId(id);
                developerModel.setName(name);
                developerModel.setSite(site);
                developerModel.setAvatar(avatar);
                developerList.add(developerModel);
            }
        });
        return developerList;
    }

    @Override
    public boolean addDeveloper(DeveloperModel developerModel) {
        String sql = "INSERT INTO developer(name,site,avatar) VALUES(" +
                "'" + developerModel.getName() + "'," +
                "'" + developerModel.getSite() + "'," +
                "'" + developerModel.getAvatar() + "'" + ");";
        System.out.println("sql=" + sql);
        try {
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean updateDeveloper(String developerId, String name) {
        String sql = "UPDATE developer SET name='" + name + "' WHERE id=" + developerId;
        System.out.println("sql=" + sql);
        try {
            jdbcTemplate.update(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean deleteDeveloper(String developerId) {
        String sql = "DELETE FROM developer WHERE id=" + developerId;
        System.out.println("sql=" + sql);
        try {
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

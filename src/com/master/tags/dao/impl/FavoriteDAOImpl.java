package com.master.tags.dao.impl;

import com.master.myssm.basedao.BaseDAO;
import com.master.tags.dao.FavoriteDAO;
import com.master.tags.pojo.Favorite;

import java.util.List;

public class FavoriteDAOImpl extends BaseDAO<Favorite> implements FavoriteDAO {
    @Override
    public int insert(Favorite favorite) {
        String sql = "INSERT INTO t_favorite(t_favorite.id, t_favorite.usrId, t_favorite.projectId) VALUES(?, ?, ?);";
        return super.executeUpdate(sql, favorite.getId(), favorite.getUserId(), favorite.getProjectId());
    }
    
    @Override
    public int update(Favorite favorite) {
        String sql = "UPDATE t_favorite SET t_favorite.usrId = ?, t_favorite.projectId = ? WHERE t_favorite.id = ?;";
        return super.executeUpdate(sql, favorite.getUserId(), favorite.getProjectId(), favorite.getId());
    }
    
    @Override
    public int delete(Favorite favorite) {
        String sql = "DELETE FROM t_favorite WHERE t_favorite.id = ?;";
        return super.executeUpdate(sql, favorite.getId());
    }
    
    @Override
    public int deleteById(Long id) {
        String sql = "DELETE FROM t_favorite WHERE t_favorite.id = ?;";
        return super.executeUpdate(sql, id);
    }
    
    @Override
    public Favorite selectOneById(Long id) {
        String sql = "SELECT t_favorite.id, t_favorite.usrId, t_favorite.projectId FROM t_favorite WHERE t_favorite.id = ?;";
        return super.load(sql, id);
    }
    
    @Override
    public List<Favorite> selectList() {
        String sql = "SELECT t_favorite.id, t_favorite.usrId, t_favorite.projectId FROM t_favorite;";
        return super.executeQuery(sql);
    }
    
    @Override
    public List<Favorite> selectListByUserId(Long userId) {
        String sql = "SELECT t_favorite.id, t_favorite.usrId, t_favorite.projectId FROM t_favorite WHERE t_favorite.userId = ?;";
        return super.executeQuery(sql, userId);
    }
    
    @Override
    public List<Favorite> selectListByProjectId(Long projectId) {
        String sql = "SELECT t_favorite.id, t_favorite.usrId, t_favorite.projectId FROM t_favorite WHERE t_favorite.projectId = ?;";
        return super.executeQuery(sql, projectId);
    }
}

package com.tensquare.qa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{

    @Query(value = "SELECT * FROM tb_problem pr,tb_pl pl WHERE pr.id = pl.problemid AND pl.labelid =? ORDER BY pr.replytime DESC", nativeQuery = true)
    public Page<Problem> newlist(String labelid, Pageable pageable);

    @Query(value = "SELECT * FROM tb_problem pr,tb_pl pl WHERE pr.id = pl.problemid AND pl.labelid =? ORDER BY pr.reply DESC", nativeQuery = true)
    public Page<Problem> hotlist(String labelid, Pageable pageable);

    @Query(value = "SELECT * FROM tb_problem pr,tb_pl pl WHERE pr.id = pl.problemid AND pl.labelid =? AND pr.reply=0 ORDER BY pr.createtime DESC", nativeQuery = true)
    public Page<Problem> waitlist(String labelid, Pageable pageable);

}

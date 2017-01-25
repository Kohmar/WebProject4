package ua.training.dao;

import ua.training.entity.Mark;

import java.util.List;

/**
 * Created by Kotov Nicholas on 25.01.2017.
 */
public interface MarkDAO {
    /**
     * Getting all marks.
     * @return
     */
    List<Mark> getAllMarks();

    /**
     * Finding mark by id.
     * @param idMark
     * @return
     */
    Mark findMarkById(Integer idMark);

    /**
     * Inserting mark.
     * @param mark
     * @return
     */
    boolean insertMark(Mark mark);

    /**
     * Updating mark.
     * @param idMark
     * @param mark
     * @return
     */
    boolean updateMark(Integer idMark, Mark mark);

    /**
     * Deleting mark.
     * @param idMark
     * @return
     */
    boolean deleteMark(Integer idMark);

}

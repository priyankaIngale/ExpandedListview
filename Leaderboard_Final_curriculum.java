package com.intellinects.intelliquiz.model;

import java.util.ArrayList;

public class Leaderboard_Final_curriculum {
    
    String local_id;
    String user_id;
    String board_id;
    String class_id;
    String subject_code;
    String topic_id;
    String final_score;
    String name;
    String email;
    String subject_name;
    String subject_score;
    String image_name;
    String username;
    String TotalScore;
    String ChapterTitle;
    String chapterId;
    String totalQuestions;
    String attemptedQuestions;
    String remark;


    String mp_boardclasssubjectId;

    ArrayList<Leaderboard_Final_curriculum> final_curriculumArrayList_details;


    private boolean isSectionHeader;

    public Leaderboard_Final_curriculum() {
    }

    public Leaderboard_Final_curriculum(String name, String subject_name, String ChapterTitle, String user_id, boolean isSectionHeader) {
        this.name = name;
        this.subject_name = subject_name;
        this.ChapterTitle = ChapterTitle;
        this.user_id = user_id;
        this.isSectionHeader = isSectionHeader;
    }
    public ArrayList<Leaderboard_Final_curriculum> getFinal_curriculumArrayList_details() {
        return final_curriculumArrayList_details;
    }

    public void setFinal_curriculumArrayList_details(ArrayList<Leaderboard_Final_curriculum> final_curriculumArrayList_details) {
        this.final_curriculumArrayList_details = final_curriculumArrayList_details;
    }

    public String getLocal_id() {
        return local_id;
    }

    public void setLocal_id(String local_id) {
        this.local_id = local_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getBoard_id() {
        return board_id;
    }

    public void setBoard_id(String board_id) {
        this.board_id = board_id;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getSubject_code() {
        return subject_code;
    }

    public void setSubject_code(String subject_code) {
        this.subject_code = subject_code;
    }

    public String getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public String getFinal_score() {
        return final_score;
    }

    public void setFinal_score(String final_score) {
        this.final_score = final_score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getSubject_score() {
        return subject_score;
    }

    public void setSubject_score(String subject_score) {
        this.subject_score = subject_score;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTotalScore() {
        return TotalScore;
    }

    public void setTotalScore(String totalScore) {
        TotalScore = totalScore;
    }

    public String getChapterTitle() {
        return ChapterTitle;
    }

    public void setChapterTitle(String chapterTitle) {
        ChapterTitle = chapterTitle;
    }

    public String getChapterId() {
        return chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public String getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(String totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public String getAttemptedQuestions() {
        return attemptedQuestions;
    }

    public void setAttemptedQuestions(String attemptedQuestions) {
        this.attemptedQuestions = attemptedQuestions;
    }
    public String getMp_boardclasssubjectId() {
        return mp_boardclasssubjectId;
    }

    public void setMp_boardclasssubjectId(String mp_boardclasssubjectId) {
        this.mp_boardclasssubjectId = mp_boardclasssubjectId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public boolean isSectionHeader() {
        return isSectionHeader;
    }

    public void setSectionHeader(boolean sectionHeader) {
        isSectionHeader = sectionHeader;
    }

}

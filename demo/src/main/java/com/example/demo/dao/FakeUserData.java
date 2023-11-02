package com.example.demo.dao;

import com.example.demo.model.User;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeUser")
public class FakeUserData implements UserDao {
    private List<User> db = new ArrayList<>();

    @Override
    public int insertUser(UUID id, User user) {
        db.add(new User(id, user.getAge(), user.getName()));
        return 1;
    }

    @Override
    public List<User> selectAllUser() {
        return db;
    }

    @Override
    public Optional<User> selectUserById(UUID id) {
        return db.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    @Override
    public int deleteUserById(UUID id) {
        Optional<User> selectedUserToDelete = selectUserById(id);
        if (selectedUserToDelete.isEmpty()){
            return 0;
        }else {
            db.remove(selectedUserToDelete.get());
            return 1;
        }
    }

    @Override
    public int updateUserById(UUID id, User user) {
        return selectUserById(id).map(u ->{
            int index = db.indexOf(u);
            if (index>=0){
                db.set(index,new User(id,user.getAge(),user.getName()));
                return 1;
            }
            return 0;
        })
                .orElse(0);
    }
}

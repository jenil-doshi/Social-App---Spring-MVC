package com.sjsu.cmpe275.lab2.dao;

import com.sjsu.cmpe275.lab2.model.*;

public interface IFriendDao {

	public void addFriend(Long id1, Long id2);
	public void deleteFriend(Long id1, Long id2);
}

import React from 'react';
import { ReactComponent as MyInfo } from 'assets/icons/info.svg';
import { ReactComponent as MyActivity } from 'assets/icons/activity.svg';
import { ReactComponent as MyArticle } from 'assets/icons/article.svg';

export const MypageMenus = [
	{ key: 0, name: '내 정보', path: '/index/mypage/info', icon: <MyInfo /> },
	{ key: 1, name: '활동 내역', path: '/index/mypage/activity', icon: <MyActivity /> },
	{ key: 2, name: '모은 기사', path: '/index/mypage/article', icon: <MyArticle /> },
];

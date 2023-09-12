import React from 'react';
import { ReactComponent as Home } from 'assets/icons/home.svg';
import { ReactComponent as Article } from 'assets/icons/article.svg';
import { ReactComponent as Vocabulary } from 'assets/icons/vocabulary.svg';
import { ReactComponent as Game } from 'assets/icons/game.svg';
import { ReactComponent as Quiz } from 'assets/icons/quiz.svg';

export const Menus = [
	{ key: 0, name: '홈', path: '/index', icon: <Home /> },
	{ key: 1, name: '기사찾기', path: '/index/article', icon: <Article /> },
	{ key: 2, name: '나만의 단어장', path: '/index/vocabulary', icon: <Vocabulary /> },
	{ key: 3, name: '단어 게임', path: '/index/game', icon: <Game /> },
	{ key: 4, name: '주간 단어 퀴즈', path: '/index/quiz', icon: <Quiz /> },
];

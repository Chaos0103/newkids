import React from 'react';
import { ReactComponent as Logo } from 'assets/imgs/newkids-logo.svg';
import SearchBar from 'components/atoms/common/SearchBar';
import Button from 'components/atoms/common/Button';
import { NavBarContainer } from './style';

function NavBar() {
	return (
		<NavBarContainer>
			<div className="logo">
				<Logo />
			</div>
			<div className="search-bar">
				<SearchBar />
			</div>
			<Button disabled size="l" radius="s" color="SubSecond" text="로그인" handleClick={() => {}} />
		</NavBarContainer>
	);
}

export default NavBar;

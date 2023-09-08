import React from 'react';
import { ReactComponent as Logo } from 'assets/imgs/newkids-logo.svg';
import SearchBar from 'components/atoms/common/SearchBar';
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
		</NavBarContainer>
	);
}

export default NavBar;

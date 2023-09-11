import React from 'react';
import MenubarItem from 'components/atoms/common/MenubarItem';
import { Menus } from 'constants/common';
import { MenubarContainer } from './style';

function Menubar() {
	return (
		<MenubarContainer>
			{Menus.map((el) => (
				<MenubarItem key={el.key} menu={el} />
			))}
		</MenubarContainer>
	);
}

export default Menubar;

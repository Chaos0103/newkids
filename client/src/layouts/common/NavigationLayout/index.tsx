import React, { ReactNode } from 'react';
import { NavigationLayoutWrapper } from './style';

interface INavigationLayoutProps {
	Navibar: ReactNode;
	Menubar: ReactNode;
}

function NavigationLayout({ Navibar, Menubar }: INavigationLayoutProps) {
	return (
		<NavigationLayoutWrapper>
			<div className="navigation-container">
				<div className="navibar">{Navibar}</div>
				<div className="menubar">{Menubar}</div>
			</div>
		</NavigationLayoutWrapper>
	);
}

export default NavigationLayout;

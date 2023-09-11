import React, { ReactNode, useEffect, useState } from 'react';
import { NavigationLayoutWrapper } from './style';

interface INavigationLayoutProps {
	Navibar: ReactNode;
	Menubar: ReactNode;
}

function NavigationLayout({ Navibar, Menubar }: INavigationLayoutProps) {
	const [activeMenu, setActiveMenu] = useState(false);
	const [position, setPosition] = useState(0);

	function onScroll() {
		setPosition(window.scrollY);
	}

	const active = () => {
		setActiveMenu(true);
	};

	const inactive = () => {
		if (position !== 0) {
			setActiveMenu(false);
		}
	};

	useEffect(() => {
		if (position === 0) {
			setActiveMenu(true);
		} else {
			setActiveMenu(false);
		}
	}, [position]);

	useEffect(() => {
		window.addEventListener('scroll', onScroll);

		return () => {
			window.removeEventListener('scroll', onScroll);
		};
	}, []);

	return (
		<NavigationLayoutWrapper>
			<div className="navigation-container" onMouseEnter={active} onMouseLeave={inactive}>
				<div className="navibar">{Navibar}</div>
				{activeMenu ? <div className="menubar">{Menubar}</div> : <div />}
			</div>
		</NavigationLayoutWrapper>
	);
}

export default NavigationLayout;

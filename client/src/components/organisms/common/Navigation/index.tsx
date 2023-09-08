import React from 'react';
import NavBar from 'components/organisms/common/Navbar';
import Menubar from 'components/organisms/common/Menubar';
import NavigationLayout from 'layouts/common/NavigationLayout';

function Navigation() {
	return <NavigationLayout Navibar={<NavBar />} Menubar={<Menubar />} />;
}

export default Navigation;

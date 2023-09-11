import React from 'react';
import { Navigate, Outlet } from 'react-router-dom';

function PrivateRoute() {
	// TODO : API 나오면, API 연결 및 Recoil 적용
	const user = false;
	return user ? <Outlet /> : <Navigate to="/account/login" />;
}
export default PrivateRoute;

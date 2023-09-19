import useMemberInfo from 'hooks/useMemberInfo';
import React from 'react';
import { Navigate, Outlet } from 'react-router-dom';

function PrivateRoute() {
	const memberInfoState = useMemberInfo();

	return memberInfoState ? <Outlet /> : <Navigate to="/auth/login" />;
}
export default PrivateRoute;

import React, { Dispatch, SetStateAction, useState } from 'react';
import axios from 'axios';
import Swal from 'sweetalert2';
import Button from 'components/atoms/common/Button';
import { AlertContainer } from './style';

interface IAlertProps {
	setStep: Dispatch<SetStateAction<number>>;
	imageUrls: string;
	imageHeights: number;
	titles: string;
	confirms: string;
	colors: string;
}

function Alert({ setStep, imageUrls, imageHeights, titles, confirms, colors }: IAlertProps) {
	const [num, setNum] = useState(0);
	console.log(num);
	const alert = () =>
		axios.get(`//api.github.com/users/bandozen`).then(() => {
			Swal.fire({
				imageUrl: imageUrls,
				imageHeight: imageHeights,
				title: titles,
				confirmButtonColor: colors,
				confirmButtonText: confirms,
			}).then(() => {
				setNum(1);
				setStep(2);
			});
		});
	return (
		<AlertContainer>
			<Button size="s" radius="m" color="Primary" text="제출" handleClick={alert} />
		</AlertContainer>
	);
}

export default Alert;

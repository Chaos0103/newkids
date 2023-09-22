import React, { Dispatch, SetStateAction } from 'react';
import axios from 'axios';
import Swal from 'sweetalert2';
import Button from 'components/atoms/common/Button';
import { AlertContainer } from './style';

interface IAlertProps {
	setStep: Dispatch<SetStateAction<number>>;
	imageUrls: string;
	imageHeights: number;
	titles: string;
	texts: string;
	confirms: string;
	colors: string;
}

function Alert({ setStep, imageUrls, imageHeights, titles, texts, confirms, colors }: IAlertProps) {
	const alert = () =>
		axios.get(`//api.github.com/users/bandozen`).then(() => {
			Swal.fire({
				imageUrl: imageUrls,
				imageHeight: imageHeights,
				title: titles,
				text: texts,
				confirmButtonColor: colors,
				confirmButtonText: confirms,
			}).then(() => {
				setStep(3);
			});
		});
	return (
		<AlertContainer>
			<Button size="s" radius="m" color="Primary" text="제출" handleClick={alert} />
		</AlertContainer>
	);
}

export default Alert;

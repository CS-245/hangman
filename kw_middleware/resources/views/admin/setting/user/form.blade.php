@extends('layouts.admin.app')

@section('header')
    <link href="{{asset('vendor/bootstrap-multiselect/css/bootstrap-multiselect.css')}}" rel="stylesheet">
@endsection

@section('content')
    <div class="row wrapper border-bottom white-bg page-heading">
        <div class="col-lg-10">
            <h2>User List</h2>
            <ol class="breadcrumb">
                <li>
                    <a href="{{ url('/admin') }}">Home</a>
                </li>
                <li>
                    <a>User Management</a>
                </li>
                <li class="active">
                    <strong>User Register</strong>
                </li>
            </ol>
        </div>
    </div>

    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div class="col-lg-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>
                        </h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <form method="POST" class="form-horizontal" action="{{ $view_type == 'Create' ? url('/admin/user/register-processing') : url('/admin/user/edit-processing') }}">
                            {{ csrf_field() }}
                            @if($view_type == 'Update')
                                <input type="hidden" name="user_id" value="{{ $user->user_id }}" />
                            @endif
                            <div class="form-group{{ $errors->has('first_name') ? ' has-error' : '' }}">
                                <label class="col-sm-2 control-label">First Name</label>
                                <div class="col-sm-10">
                                    <input type="text" name="first_name" class="form-control" value="{{ empty(old('first_name')) && isset($user) ? $user->first_name : old('first_name') }}" required>
                                    @if ($errors->has('first_name'))
                                        <div class="alert alert-danger">
                                            <strong>{{ $errors->first('first_name') }}</strong>
                                        </div>
                                    @endif
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group{{ $errors->has('last_name') ? ' has-error' : '' }}">
                                <label class="col-sm-2 control-label">Last ame</label>
                                <div class="col-sm-10">
                                    <input type="text" name="last_name" class="form-control" value="{{ empty(old('last_name')) && isset($user) ? $user->last_name : old('last_name') }}" required>
                                    @if ($errors->has('last_name'))
                                        <div class="alert alert-danger">
                                            <strong>{{ $errors->first('last_name') }}</strong>
                                        </div>
                                    @endif
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group{{ $errors->has('email') ? ' has-error' : '' }}">
                                <label class="col-sm-2 control-label">Email</label>
                                <div class="col-sm-10">
                                    <input type="text" name="email" class="form-control" value="{{ empty(old('email')) && isset($user) ? $user->email : old('email') }}"
                                           @if ($view_type == 'Create') required @else readonly @endif
                                    >
                                    @if ($errors->has('email'))
                                        <div class="alert alert-danger">
                                            <strong>{{ $errors->first('email') }}</strong>
                                        </div>
                                    @endif
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group{{ $errors->has('cell_phone') ? ' has-error' : '' }}">
                                <label class="col-sm-2 control-label">Phone</label>
                                <div class="col-sm-10">
                                    <input type="text" name="cell_phone" class="form-control" value="{{ empty(old('cell_phone')) && isset($user) ? $user->cell_phone : old('cell_phone') }}" required>
                                    @if ($errors->has('cell_phone'))
                                        <div class="alert alert-danger">
                                            <strong>{{ $errors->first('cell_phone') }}</strong>
                                        </div>
                                    @endif
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group{{ $errors->has('password') ? ' has-error' : '' }}">
                                <label class="col-sm-2 control-label">Password</label>
                                <div class="col-sm-10">
                                    <input type="password" name="password" class="form-control" @if ($view_type == 'Create') required @endif>
                                    @if ($errors->has('password'))
                                        <div class="alert alert-danger">
                                            <strong>{{ $errors->first('password') }}</strong>
                                        </div>
                                    @endif
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group{{ $errors->has('password') ? ' has-error' : '' }}">
                                <label class="col-sm-2 control-label">Confirm Password</label>
                                <div class="col-sm-10">
                                    <input id="password-confirm" type="password" class="form-control" name="password_confirmation" @if ($view_type == 'Create') required @endif>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            @if($view_type == 'Update')
                            <div class="form-group"><label class="col-sm-2 control-label">Activation</label>
                                <div class="col-sm-10">
                                    <input type="checkbox" id="check-activate-yn" class="form-control" {{ $user->activate_yn == 'Y' ? 'checked' :'' }}>
                                    <input type="hidden" name="activate_yn" value="{{ $user->activate_yn == 'Y' }}">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            @endif
                            <div class="form-group{{ $errors->has('auth') ? ' has-error' : '' }}">
                                <label class="col-sm-2 control-label">Auth</label>
                                <div class="col-sm-10">
                                    <select id="select-permission" name="auth[]" class="form-control" multiple>
                                        @foreach($roles as $role)
                                            @if($view_type == 'Create' || !empty(old('auth')))
                                                <option value="{{$role->id}}" {{ !empty(old('auth')) && in_array($role->id, old('auth')) ? 'selected' : ''}}>{{ $role->name }}</option>
                                            @else
                                                <option value="{{$role->id}}" {{ (!is_null($user->roles) && $user->roles->where('id', $role->id)->count() > 0) ? 'selected' : ''}}>{{ $role->name }}</option>
                                            @endif
                                        @endforeach
                                    </select>
                                    @if ($errors->has('auth'))
                                        <div class="alert alert-danger">
                                            <strong>{{ $errors->first('auth') }}</strong>
                                        </div>
                                    @endif
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="text-right">
                                <button type="submit" class="btn btn-primary">Save & Close</button>
                                <a href="{{ url('admin/user/list') }}" class="btn btn-danger">Cancel</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
@endsection

@section('after-script')
    <script src="{{ asset('vendor/bootstrap-multiselect/js/bootstrap-multiselect.js') }}"></script>
    <script src="{{ asset('js/views/admin/setting-user-form.js') }}"></script>
@endsection

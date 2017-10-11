@extends('layouts.admin.app')

@section('header')
    <link href="{{asset('vendor/bootstrap-multiselect/css/bootstrap-multiselect.css')}}" rel="stylesheet">
@endsection

@section('content')
    <div class="row wrapper border-bottom white-bg page-heading">
        <div class="col-lg-10">
            <h2>Role Register</h2>
            <ol class="breadcrumb">
                <li>
                    <a href="{{ url('/admin') }}">Home</a>
                </li>
                <li>
                    <a>Role Management</a>
                </li>
                <li class="active">
                    <strong>Role Register</strong>
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
                        <form method="POST" class="form-horizontal" action="{{ $view_type == 'Create' ? url('/admin/role/register-processing') : url('/admin/role/edit-processing') }}">
                            {{ csrf_field() }}
                            @if($view_type == 'Update')
                                <input type="hidden" name="role_id" value="{{ $role->id }}" />
                            @endif
                            <div class="form-group{{ $errors->has('name') ? ' has-error' : '' }}"><label class="col-sm-2 control-label">Name</label>
                                <div class="col-sm-10">
                                    <input type="text" name="name" class="form-control" value="{{ empty(old('name')) && isset($role->name) ? $role->name : old('name') }}" required>
                                    @if ($errors->has('name'))
                                        <div class="alert alert-danger">
                                            <strong>{{ $errors->first('name') }}</strong>
                                        </div>
                                    @endif
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group{{ $errors->has('permission') ? ' has-error' : '' }}"><label class="col-sm-2 control-label">Permissions</label>
                                <div class="col-sm-10">
                                    <select id="select-permission" name="permission[]" class="form-control" multiple>
                                        @foreach($permissions as $permission)
                                            @if($view_type == 'Create' || !empty(old('permission')))
                                                <option value="{{ $permission->id }}"
                                                        {{ !empty(old('permission')) && in_array($permission->id, old('permission')) ? 'selected' : '' }}>{{ $permission->name }}</option>
                                            @else
                                                <option value="{{ $permission->id }}"
                                                        {{ (!is_null($role->permissions) && $role->permissions->where('id', $permission->id)->count() > 0) ? 'selected' : '' }}>{{ $permission->name }}</option>
                                            @endif
                                        @endforeach
                                    </select>
                                    @if ($errors->has('permission'))
                                        <div class="alert alert-danger">
                                            <strong>{{ $errors->first('permission') }}</strong>
                                        </div>
                                    @endif
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="text-right">
                                <button type="submit" class="btn btn-primary">Save & Close</button>
                                <a href="{{ url('admin/role/list') }}" class="btn btn-danger">Cancel</a>
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
    <script src="{{ asset('js/views/admin/setting-role-form.js') }}"></script>
@endsection
